package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*

object CustomCommandExampleHelp : BuildType({
    name = "custom command example (help)"

    vcs {
        root(_Self.vcsRoots.HttpsGithubComBurnashevaNunitCoreTestsRefsHeadsMaster)

        cleanCheckout = true
    }

    steps {
        step {
            type = "dotnet.cli"
            enabled = false
            param("args", "migrate PrimeService.Tests/PrimeService.Tests.csproj")
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
            param("command", "-")
        }
        step {
            type = "dotnet.cli"
            param("args", "help")
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
            param("command", "-")
        }
    }
})
