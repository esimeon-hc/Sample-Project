import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildFeatures.swabra
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetBuild
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2018_1.vcs.GitVcsRoot

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

version = "2018.1"

project {
    description = "Contains all other projects"

    features {
        feature {
            id = "PROJECT_EXT_1"
            type = "ReportTab"
            param("startPage", "coverage.zip!index.html")
            param("title", "Code Coverage")
            param("type", "BuildReportTab")
        }
    }

    cleanup {
        preventDependencyCleanup = false
    }

    subProject(SampleProject)
    subProject(SampleProject2)
}


object SampleProject : Project({
    name = "Sample Project"

    buildType(SampleProject_Build)

    subProject(SampleProject_Subproject1)
})

object SampleProject_Build : BuildType({
    name = "Build"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        maven {
            goals = "clean test"
            mavenVersion = defaultProvidedVersion()
        }
    }

    triggers {
        vcs {
        }
    }

    features {
        swabra {
        }
    }
})


object SampleProject_Subproject1 : Project({
    name = "Subproject1"

    vcsRoot(SampleProject_Subproject1_HttpsGithubComJuliaAlexandrovaMyProjects1refsHeadsMast)

    buildType(SampleProject_Subproject1_Subproject1Build)
})

object SampleProject_Subproject1_Subproject1Build : BuildType({
    name = "Subproject1_Build"

    vcs {
        root(SampleProject_Subproject1_HttpsGithubComJuliaAlexandrovaMyProjects1refsHeadsMast)
    }

    steps {
        dotnetBuild {
            projects = "Solutions/CSharp.sln"
        }
    }

    triggers {
        vcs {
        }
    }
})

object SampleProject_Subproject1_HttpsGithubComJuliaAlexandrovaMyProjects1refsHeadsMast : GitVcsRoot({
    name = "https://github.com/Julia-Alexandrova/My-Projects1#refs/heads/master"
    url = "https://github.com/Julia-Alexandrova/My-Projects1"
    param("teamcity:vcsResourceDiscovery:versionedSettingsRoot", "false")
})


object SampleProject2 : Project({
    name = "Sample Project 2"

    vcsRoot(SampleProject2_HttpsGithubComJuliaAlexandrovaJavaSampleRefsHeadsMaster)

    buildType(SampleProject2_Build2)
})

object SampleProject2_Build2 : BuildType({
    name = "Build 2"

    vcs {
        root(SampleProject2_HttpsGithubComJuliaAlexandrovaJavaSampleRefsHeadsMaster)
    }

    steps {
        maven {
            goals = "clean test"
            mavenVersion = defaultProvidedVersion()
        }
    }

    triggers {
        vcs {
        }
    }
})

object SampleProject2_HttpsGithubComJuliaAlexandrovaJavaSampleRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/Julia-Alexandrova/java_sample#refs/heads/master"
    url = "https://github.com/Julia-Alexandrova/java_sample"
    param("teamcity:vcsResourceDiscovery:versionedSettingsRoot", "false")
})
