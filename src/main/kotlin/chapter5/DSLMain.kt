package chapter5

fun main(args: Array<String>) {
    html {
        "id"("HtmlId")
        "head"{
            "id"("headId")
        }
        body {
            id = "bodyId"
            `class` = "bodyClass"

            "a"{
                "href"("https://www.kotliner.cn")
                +"Kotlin 中文博客"
            }
        }

        "div"{

        }


    }.render().let(::println)
}