package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.DotnetBuildStep
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.DotnetCleanStep
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.DotnetNugetDeleteStep
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.DotnetNugetPushStep
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.DotnetPackStep
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetBuild
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetClean
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetMsBuild
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetNugetDelete
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetNugetPush
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetPack
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetPublish
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetRestore
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetRun
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetTest
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetVsTest

object TestFields : BuildType({
    name = "test fields"

    vcs {
        root(_Self.vcsRoots.HttpsGithubComBurnashevaNunitCoreTestsRefsHeadsMaster)
    }

    steps {
        dotnetBuild {
            name = "step name"
            projects = "PrimeService/PrimeService.csproj PrimeService.Tests/PrimeService.Tests.csproj PrimeService.Tests/PrimeService_IsPrimeShould.cs PrimeService/PrimeService.csproj"
            workingDir = "PrimeService"
            framework = "3.4.4"
            configuration = "Release"
            runtime = "x86"
            outputDir = "output/bla"
            versionSuffix = "suffix"
            args = "-parameters"
            logging = DotnetBuildStep.Verbosity.Quiet
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
        dotnetClean {
            name = "clean"
            projects = "PrimeService/PrimeService.csproj README.md PrimeService/PrimeService.cs PrimeService/PrimeService.csproj"
            workingDir = "PrimeService"
            framework = "3.4.5"
            configuration = "Debug"
            runtime = "x64"
            outputDir = "output"
            args = "-bla=bla"
            logging = DotnetCleanStep.Verbosity.Minimal
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
        dotnetMsBuild {
            name = "msbuild step"
            projects = "PrimeService.Tests/PrimeService.Tests.csproj PrimeService/PrimeService.csproj"
            workingDir = "PrimeService.Test"
            targets = "Rebuild"
            configuration = "Debug"
            runtime = "x86"
            args = "-param=value"
            coverage = dotcover {
                toolPath = "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%"
                assemblyFilters = "+:someAss.dll"
                attributeFilters = "attribute"
                args = "command line arguments"
            }
        }
        dotnetNugetDelete {
            name = "nuget delete step"
            serverUrl = "%teamcity.nuget.feed.server%"
            packageId = "MyPackage.0.3.8"
            apiKey = "zxx19601937114f6f6160d95aba0b9124f70b2618efed09e7fb"
            args = "-parameters"
            logging = DotnetNugetDeleteStep.Verbosity.Normal
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
        dotnetNugetPush {
            name = "nuget push step"
            packages = "*.nupkg"
            serverUrl = "%teamcity.nuget.feed.server%"
            apiKey = "zxx61f89bca1f9b9ac8400f518362b9dc58ec0bd1aa96f4a2c4d3bf3725bfb0a1b0"
            noSymbols = true
            args = "-some -parameters"
            logging = DotnetNugetPushStep.Verbosity.Detailed
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
        dotnetPack {
            name = "pack step"
            projects = "PrimeService/PrimeService.csproj PrimeService.Tests/PrimeService.Tests.csproj"
            workingDir = "PrimeService"
            configuration = "Release"
            runtime = "x86"
            outputDir = "output"
            versionSuffix = "suffix"
            skipBuild = true
            args = "-some parameters"
            logging = DotnetPackStep.Verbosity.Diagnostic
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
        dotnetPublish {
            name = "publish step"
            projects = "PrimeService/PrimeService.csproj PrimeService/PrimeService.csproj PrimeService/PrimeService.cs"
            workingDir = "PrimeService"
            framework = "4.5.6"
            configuration = "Release"
            runtime = "x64"
            outputDir = "output"
            versionSuffix = "suffix"
            args = "-some -parameters"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
        dotnetRestore {
            name = "restore step"
            projects = "PrimeService/PrimeService.csproj"
            sources = """
                %teamcity.nuget.feed.server%
                https://nuget.org
            """.trimIndent()
            runtime = "x86"
            packagesDir = """C:\packages"""
            configFile = """C:\nuget.config"""
            args = "-some -parameters"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
        dotnetRun {
            name = "run step"
            projects = "PrimeService.Tests/PrimeService.Tests.csproj"
            workingDir = "PrimeService.Tests"
            framework = "3.5.5"
            configuration = "Release"
            runtime = "x64"
            args = "-some -parameters"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
        dotnetTest {
            name = "test step"
            projects = "PrimeService.Tests/PrimeService.Tests.csproj PrimeService/PrimeService.csproj README.md"
            workingDir = "."
            filter = "some filter"
            framework = "4.5.6"
            configuration = "Release"
            outputDir = "output"
            skipBuild = true
            settingsFile = "some-settings"
            args = "-additional -parameters"
            coverage = dotcover {
                toolPath = "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%"
                assemblyFilters = "assembly.dll"
                attributeFilters = "+:attribute"
                args = "-additional -arguments"
            }
        }
        dotnetVsTest {
            name = "vstest step"
            assemblies = "PrimeService.Tests/PrimeService.Tests.csproj"
            workingDir = "PrimeService.Tests"
            filter = testName {
                names = """
                    +:names
                    +:other-names
                """.trimIndent()
            }
            framework = "4.5.6"
            settingsFile = "file.settings"
            args = "-parameter"
            param("dotNetCoverage.dotCover.home.path", "%teamcity.tool.JetBrains.dotCover.CommandLineTools.DEFAULT%")
        }
    }
})
