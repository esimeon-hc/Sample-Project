package _Self.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.vcs.GitVcsRoot

object HttpsGithubComBurnashevaNunitCoreTestsRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/burnasheva/nunit_core_tests#refs/heads/master"
    url = "https://github.com/burnasheva/nunit_core_tests"
})
