package Publish

import Publish.buildTypes.*
import Publish.vcsRoots.*
import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.Project

object Project : Project({
    id("Publish")
    name = "publish"

    vcsRoot(Publish_HttpsGithubComBurnashevaCoreExeGitRefsHeadsMaster)
    vcsRoot(Publish_HttpsGithubComBurnashevaCoreExeGit)

    buildType(Publish_OutsideOfWorkingDirectory)
    buildType(Publish_PublishExePackage)
    buildType(Publish_DoNotFailBuildWithExitCode1)
})
