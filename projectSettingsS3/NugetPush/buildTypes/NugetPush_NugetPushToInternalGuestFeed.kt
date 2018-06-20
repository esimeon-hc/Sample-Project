package NugetPush.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetBuild
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetNugetPush
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetPack
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetRestore

object NugetPush_NugetPushToInternalGuestFeed : BuildType({
    name = "nuget push to internal guest feed"

    vcs {
        root(NugetPush.vcsRoots.NugetPush_HttpsGithubComBurnashevaMstestDotnet2git)
    }

    steps {
        dotnetRestore {
            projects = "MSTestCore.sln"
        }
        dotnetBuild {
            projects = "MSTestCore.sln"
        }
        dotnetPack {
            projects = "PrimeService/PrimeService.csproj"
            outputDir = "packages"
            args = "/p:PackageVersion=0.%build.counter%.0"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
        dotnetNugetPush {
            packages = "PrimeService/packages/PrimeService.0.%build.counter%.0.nupkg"
            serverUrl = "%teamcity.nuget.feed.server%"
            apiKey = "zxx61f89bca1f9b9ac8400f518362b9dc58ec0bd1aa96f4a2c4d3bf3725bfb0a1b0"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
    }
})
