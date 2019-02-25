import com.rsk.Providers

fun main() {
    val providers = Providers()
    val details = providers.getAllProvidersExtendedVersion("Random")

    details.forEach(::println)

//    getAllProviders{
//        key, value -> println("\t ----- $key: $value")
//    }
}

fun getAllProviders(fn: (String, String) -> Unit){ // return void (Unit)
    val allProviders = Providers.getProviders()

    val iter = allProviders.iterator()

    while (iter.hasNext()) {
        val provider = iter.next()
        println(provider.name)

        provider.forEach { key, value -> fn(key.toString(), value.toString()) }
    }
}

