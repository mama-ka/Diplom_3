import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.projectFeatures.githubAppConnection
import jetbrains.buildServer.configs.kotlin.triggers.vcs

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2023.05"

project {

    buildType(Build)

    features {
        githubAppConnection {
            id = "PROJECT_EXT_34"
            displayName = "NewApp"
            appId = "381000111"
            clientId = "Iv1.4e9bf005b09c0efb"
            clientSecret = "credentialsJSON:2c460a70-94ef-402b-b926-5f69b8ec40fd"
            privateKey = "credentialsJSON:1899b9cb-c8b2-4f76-af84-4d25089ec1e1"
            ownerUrl = "https://github.com/dumamoiseev"
        }
        githubAppConnection {
            id = "PROJECT_EXT_36"
            displayName = "GitHub App (2)"
            appId = "123"
            clientId = "123"
            clientSecret = "credentialsJSON:2c7c0543-a06e-42f3-af68-e6157f2d8c0c"
            privateKey = "credentialsJSON:1899b9cb-c8b2-4f76-af84-4d25089ec1e1"
            ownerUrl = "https://github.com/username)"
        }
    }
}

object Build : BuildType({
    name = "Build"

    vcs {
        root(DslContext.settingsRoot)
    }

    triggers {
        vcs {
        }
    }

    features {
        perfmon {
        }
    }
})
