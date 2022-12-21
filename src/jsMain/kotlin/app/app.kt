package app

import dev.fritz2.core.render
import dev.fritz2.core.storeOf
import model.Framework
import model.name

fun main() {

    val frameworkStore = storeOf(Framework("fritz2"))
    val nameStore = frameworkStore.map(Framework.name())

    render {
        // card
        div("bg-gray-50 max-w-2xl mx-auto sm:px-6 lg:px-8 py-12") {
            div("overflow-hidden shadow-md") {

                // card-header
                // Hier sieht man, wie Tailwind arbeitet, man kann die Klassen von Tailwind einfach nutzen.
                div("px-0 py-0 text-white bg-sky-700 border-b border-gray-200 font-bold lowercase") {
                    +"Which web-framework do you use?"
                }

                // card body
                div("p-6 bg-cyan-500") {
                    +"I'm using: "
                    nameStore.data.renderText()
                }
            }
        }
    }
}