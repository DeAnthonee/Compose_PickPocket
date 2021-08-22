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
            "Stacy",
            "Udes",
            "Urchala",
            "Sarah",
            "Stacy",
            "Lee",
            "Rock",
            "Rachel",
            "Jamie",
            "Jill",
            "Jerry",
            "Rick",
            "Morty",
            "Tilly",
            "Candy",
            "Celina",
            "Eddy",
            "Erin",
            "Javin",
            "Junior",
            "Jerome",
            "Heather",
            "Heman",
            "Hurmon",
            "Ian",
            "Illy",
            "Nina",
            "Nancy",
            "Nelly",
            "Mindy",
            "Mandy",
            "Niko",
            "Ossim",
            "Queen",
            "Quila",
            "Veronica",
            "Van",
            "Venison",
            "Wally",
            "Wiltrox",
            "Willow",
            "Zinny"
        )
        val listOfLastNames = listOf(
            "Uchia",
            "Uzamaki",
            "Keen",
            "Landings",
            "Cummings",
            "Joels",
            "Kent",
            "Lane",
            "Wayne",
            "Rogers",
            "Lord",
            "Gurchin",
            "Plorgio",
            "Flores",
            "Guazena",
            "Horston",
            "Hill",
            "Inges",
            "Ichiro",
            "Jameson",
            "Kelly",
            "Kourn",
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