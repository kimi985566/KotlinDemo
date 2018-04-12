package chapter5

fun html(block: Tag.() -> Unit): Tag {
    //block 可以当做参数传入， 也可以当做返回值返回。

    return Tag("html").apply(block)
}

fun Tag.head(block: Head.() -> Unit) {
    this + Head().apply(block)
}

fun Tag.body(block: Body.() -> Unit) {
    this + Body().apply(block)
}

class StringNode(val content: String) : Node {
    override fun render() = content
}

class Head : Tag("head")

class Body : Tag("body") {
    var id by MapDelegate(properties)

    var `class` by MapDelegate(properties)
}