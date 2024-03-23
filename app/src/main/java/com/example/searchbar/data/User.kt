/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.searchbar.data

import java.util.Locale

/**
 * An object which represents an account which can belong to a user. A single user can have
 * multiple accounts.
 */
data class User(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val email: String,
    val altEmail: String,
    var isCurrentAccount: Boolean = false
) {
    val fullName: String = "$firstName $lastName"
}


val firstNames = listOf(
    "Emma", "Olivia", "Ava", "Isabella", "Sophia",
    "Charlotte", "Mia", "Amelia", "Harper", "Evelyn",
    "Abigail", "Emily", "Elizabeth", "Mila", "Ella",
    "Scarlett", "Luna", "Sofia", "Avery", "Camila",
    "Aria", "Grace", "Chloe", "Penelope", "Layla",
    "Riley", "Zoey", "Nora", "Lily", "Mila",
    "Eleanor", "Hannah", "Lillian", "Addison", "Aubrey",
    "Ellie", "Stella", "Natalie", "Zoe", "Leah",
    "Hazel", "Violet", "Aurora", "Savannah", "Audrey",
    "Brooklyn", "Bella", "Claire", "Skylar", "Lucy",
    "Paisley", "Everly", "Anna", "Caroline", "Nova",
    "Genesis", "Emilia", "Kennedy", "Samantha", "Maya",
    "Willow", "Kinsley", "Naomi", "Aaliyah", "Elena",
    "Sarah", "Ariana", "Allison", "Gabriella", "Alice",
    "Madelyn", "Cora", "Ruby", "Eva", "Serenity",
    "Autumn", "Adeline", "Hailey", "Gianna", "Valentina",
    "Isla", "Eliana", "Quinn", "Nevaeh", "Ivy",
    "Sadie", "Piper", "Lydia", "Alexa", "Josephine",
    "Emery", "Julia", "Delilah", "Athena", "Arya",
    "Vivian", "Kaylee", "Sophie", "Brielle", "Madeline",
    "Peyton", "Rylee"
    // Add more first names as needed
)

val lastNames = listOf(
    "Smith", "Johnson", "Williams", "Brown", "Jones",
    "Garcia", "Miller", "Davis", "Rodriguez", "Martinez",
    "Hernandez", "Lopez", "Gonzalez", "Wilson", "Anderson",
    "Thomas", "Taylor", "Moore", "Jackson", "Martin",
    "Lee", "Perez", "Thompson", "White", "Harris",
    "Sanchez", "Clark", "Ramirez", "Lewis", "Robinson",
    "Walker", "Young", "Hall", "Allen", "King",
    "Wright", "Scott", "Torres", "Nguyen", "Hill",
    "Flores", "Green", "Adams", "Nelson", "Baker",
    "Hall", "Rivera", "Campbell", "Mitchell", "Carter",
    "Roberts", "Gomez", "Phillips", "Evans", "Turner",
    "Diaz", "Parker", "Cruz", "Edwards", "Collins",
    "Reyes", "Stewart", "Morris", "Morales", "Murphy",
    "Cook", "Rogers", "Gutierrez", "Ortiz", "Morgan",
    "Cooper", "Peterson", "Bailey", "Reed", "Kelly",
    "Howard", "Ramos", "Kim", "Cox", "Ward",
    "Richardson", "Watson", "Brooks", "Chavez", "Wood",
    "James", "Bennett", "Gray", "Mendoza", "Ruiz",
    "Hughes", "Price", "Alvarez", "Castillo", "Sanders",
    "Patel", "Myers", "Long", "Ross", "Foster",
    "Jimenez", "Powell"
    // Add more last names as needed
)

fun generateRandomEmail(name: String): String {
    return "${name.lowercase(Locale.ROOT)}@example.com"
}

fun generateDummyUser(id: Long): User {
    val firstName = firstNames.random()
    val lastName = lastNames.random()
    val email = generateRandomEmail(firstName)
    val altEmail = generateRandomEmail("$firstName.$lastName")
    return User(id, firstName, lastName, email, altEmail)
}