package com.deanthonee.composepickpocket.utils

import java.util.ArrayList

class FakeData {

    fun listOfFullNames(numberOfNames: Int): List<String> {
        val listOfFirstNames = listOf(
            "Maggie",
            "Johhny",
            "Orin",
            "Tiffany",
            "Sabrina",
            "Erin",
            "Alberto",
            "Andy",
            "Anthony",
            "DeAnthonee",
            "Dejean",
            "Demonte",
            "DeMario",
            "Kennedy-Anne",
            "Bobby",
            "Billy",
            "Corey",
            "Zappy",
            "Xina",
            "Xeolyne",
            "Stacy"
        )
        val listOfLastNames = listOf(
            "Johnson",
            "Stevens",
            "Tillsons",
            "Smiths",
            "Legend",
            "Marvel",
            "Torando",
            "Sharker",
            "Nagger",
            "Neegan",
            "Milly Wap"
        )

        val fullNames = ArrayList<String>()

        for (x in 0..numberOfNames) {
            val first = listOfFirstNames.random()
            val last = listOfLastNames.random()
            val name = "$first $last"
            fullNames.add(name)
        }
        return fullNames
    }
}