package chapter5

fun main(args: Array<String>) {
    Tag("html").apply {
        properties["id"] = "HtmlId"
        children.add(Tag("head"))
    }.render().let(::println)
}