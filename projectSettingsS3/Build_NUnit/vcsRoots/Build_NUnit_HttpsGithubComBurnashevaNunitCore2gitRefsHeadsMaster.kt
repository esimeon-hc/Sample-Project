package Build_NUnit.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.vcs.GitVcsRoot

object Build_NUnit_HttpsGithubComBurnashevaNunitCore2gitRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/burnasheva/nunit_core2.git#refs/heads/master"
    url = "https://github.com/burnasheva/nunit_core2.git"
    branch = "refs/heads/test_with_wait"
})
