package _Self.buildTypes

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.VisualStudioStep
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetBuild
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetRestore
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.dotnetTest
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.visualStudio
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs

object TestStepAutodiscovery : BuildType({
    name = "test step autodiscovery"

    vcs {
        root(_Self.vcsRoots.HttpsGithubComBurnashevaMstestCoreAdapterGit)
    }

    steps {
        visualStudio {
            path = "MSTestCore.sln"
            version = VisualStudioStep.VisualStudioVersion.vs2017
            runPlatform = VisualStudioStep.Platform.x86
            msBuildVersion = VisualStudioStep.MSBuildVersion.V15_0
            msBuildToolsVersion = VisualStudioStep.MSBuildToolsVersion.V15_0
        }
        dotnetRestore {
            projects = "MSTestCore.sln"
        }
        dotnetBuild {
            projects = "MSTestCore.sln"
        }
        dotnetTest {
            projects = "MSTestCore.sln"
        }
    }

    triggers {
        vcs {
        }
    }
})
