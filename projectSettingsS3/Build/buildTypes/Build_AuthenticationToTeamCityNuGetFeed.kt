package Build.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetBuild
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetRestore
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object Build_AuthenticationToTeamCityNuGetFeed : BuildType({
    name = "authentication to TeamCity NuGet feed"

    vcs {
        root(Build.vcsRoots.Build_HttpsGithubComBurnashevaMstestDotnet2gitRefsHeadsMaster)
    }

    steps {
        dotnetRestore {
            projects = "MSTestCore.sln"
            sources = """
                https://api.nuget.org/v3/index.json
                http://nadias-mbp.labs.intellij.net:8111/httpAuth/app/nuget/feed/_Root/default/v2
            """.trimIndent()
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
        dotnetBuild {
            projects = "MSTestCore.sln"
        }
    }

    triggers {
        vcs {
        }
    }

    features {
        feature {
            type = "jb.nuget.auth"
            param("nuget.auth.feed", "http://nadias-mbp.labs.intellij.net:8111/httpAuth/app/nuget/feed/_Root/default/v2")
            param("secure:nuget.auth.password", "zxx0feb335798e7f083")
            param("nuget.auth.username", "admin")
        }
    }
})
