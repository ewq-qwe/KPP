package ua.pavliyk

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform