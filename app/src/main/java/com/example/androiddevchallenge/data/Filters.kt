package com.example.androiddevchallenge.data

data class Filter(val text: String, val hasOptions: Boolean = false)

class FilterHelper {
    companion object {
        fun getFilters(): List<Filter>
        {
            return listOf(
                Filter("Week", true),
                Filter("ETFs"),
                Filter("Stocks"),
                Filter("Funds"),
                Filter("Funds"),
                Filter("Funds"),
                Filter("Funds"),
            )
        }
    }
}
