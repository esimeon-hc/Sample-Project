package _Self.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.vcs.GitVcsRoot

object HttpsGithubComBurnashevaNunitCore2gitRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/burnasheva/nunit_core2.git#refs/heads/master"
    url = "https://github.com/burnasheva/nunit_core2.git"
})
