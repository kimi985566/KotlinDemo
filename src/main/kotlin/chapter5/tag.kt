package chapter5

open class Tag(private val name: String) : Node {

    val children = ArrayList<Node>()

    val properties = HashMap<String, String>()

    override fun render(): String {
        return StringBuilder()
                .append("<")
                .append(name)
                .let { stringBuilder ->
                    if (!this.properties.isEmpty()) {
                        stringBuilder.append(" ")
                        this.properties.forEach {
                            stringBuilder.append(it.key)
                                    .append("=\"")//双引号
                                    .append(it.value)
                                    .append("\" ")//双引号
                        }
                    }
                    stringBuilder
                }
                .append(">")
                .let { stringBuilder ->
                    children.map(Node::render).map(stringBuilder::append)
                    stringBuilder
                }
                .append("</$name>")
                .toString()
    }


}