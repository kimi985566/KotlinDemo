package chapter5

open class Tag(private val name: String) : Node {

    val children = ArrayList<Node>()

    val properties = HashMap<String, String>()

    operator fun String.invoke(value: String) {
        properties[this] = value
    }

    operator fun String.invoke(block: Tag.() -> Unit) {
        this@Tag.children.add(Tag(this).apply(block))
    }

    operator fun String.unaryPlus() {
        children.add(StringNode(this))
    }

    operator fun plus(node: Node) {
        children.add(node)
    }

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