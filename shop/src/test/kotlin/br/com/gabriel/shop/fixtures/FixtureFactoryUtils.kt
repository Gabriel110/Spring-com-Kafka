package br.com.gabriel.shop.fixtures

import br.com.six2six.fixturefactory.Fixture
import br.com.six2six.fixturefactory.Rule

class FixtureFactoryUtils {
    companion object {
        inline fun <reified T> build(replacements: Map<String, Any?>? = emptyMap()): T {
            if (replacements!!.isEmpty()) {
                return Fixture.from(T::class.java).gimme("default")
            }

            return Fixture
                .from(T::class.java).gimme(
                    "default",
                    object : Rule() {
                        init {
                            replacements.forEach { (t, u) -> add(t, u) }
                        }
                    }
                )
        }
        inline fun <reified T> build(label: String, replacements: Map<String, Any?>? = emptyMap()): T {
            if (replacements!!.isEmpty()) {
                return Fixture.from(T::class.java).gimme(label)
            }

            return Fixture
                .from(T::class.java).gimme(
                    label,
                    object : Rule() {
                        init {
                            replacements.forEach { (t, u) -> add(t, u) }
                        }
                    }
                )
        }

        inline fun <reified T> build(quantity: Int = 1, replacements: Map<String, Any?>? = emptyMap()): MutableList<T> {

            if (replacements!!.isEmpty()) {
                return Fixture.from(T::class.java).gimme(quantity, "default")
            }

            return Fixture
                .from(T::class.java).gimme(
                    quantity,
                    "default",
                    object : Rule() {
                        init {
                            replacements.forEach { (t, u) -> add(t, u) }
                        }
                    }
                )
        }
    }
}