package NugetPush

import NugetPush.buildTypes.*
import NugetPush.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("NugetPush")
    name = "nuget push"

    vcsRoot(NugetPush_HttpsGithubComBurnashevaMstestDotnet2git)

    buildType(NugetPush_DoNotFailBuildWithExitCode1)
    buildType(NugetDelete_Wildcards)
    buildType(NugetPush_NugetPushToInternalGuestFeed)
})
