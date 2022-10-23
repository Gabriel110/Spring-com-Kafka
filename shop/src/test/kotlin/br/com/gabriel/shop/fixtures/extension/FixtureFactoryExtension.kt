package br.com.gabriel.shop.fixtures.extension


import br.com.gabriel.shop.fixtures.FixtureFactoryUtils
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext

class FixtureFactoryExtension: BeforeAllCallback  {
    override fun beforeAll(p0: ExtensionContext?) {
        FixtureFactoryLoader.loadTemplates(FixtureFactoryUtils::class.java.packageName)
    }
}