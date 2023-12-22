pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()


        maven { url = uri("https://jitpack.io") } // Corrected line
    }
}

rootProject.name = "CashFlowMate"
include(":app")
 