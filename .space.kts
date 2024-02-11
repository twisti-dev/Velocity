job("Build and publish") {
    container("Run gradle build", "eclipse-temurin:17") {
        env["REPOSITORY_URL"] = "https://packages.slne.dev/maven/p/surf/maven"

        shellScript {
            """
                sudo apt install git
            """.trimIndent()
        }

        kotlinScript { api ->
            // install git
            api.gradlew("publish", "--stacktrace")
        }
    }
}