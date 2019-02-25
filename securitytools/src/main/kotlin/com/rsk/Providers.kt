package com.rsk

import java.security.Provider
import java.security.Security

data class ProviderDetails(val providerName: String, val name: String) {}

class Providers {

    fun getProviders(): List<Provider> {
        val providers = Security.getProviders()
        return providers.asList()
    }

    fun getAllProvidersExtendedVersion(filter: String): List<ProviderDetails> {
        val providers = Security.getProviders()
        val listOfProviderDetails = mutableListOf<ProviderDetails>()

        return providers.flatMap { provider ->
            provider.entries.filter { it.key.toString().contains(filter, true) }
                .map { ProviderDetails(provider.name, it.key.toString()) }
        }

        return listOfProviderDetails
    }

    fun getAllProviders(filter: String): List<ProviderDetails> {
        val providers = Security.getProviders()
        val listOfProviderDetails = mutableListOf<ProviderDetails>()

        providers.forEach { provider ->
            val providerDetails = provider.entries.filter { it.key.toString().contains(filter, true) }
                .map { ProviderDetails(provider.name, it.key.toString()) }
            listOfProviderDetails += providerDetails
        }
        return listOfProviderDetails
    }

    companion object {
        fun getProviders(): List<Provider> {
            val providers = Security.getProviders()
            return providers.asList()
        }
    }
}