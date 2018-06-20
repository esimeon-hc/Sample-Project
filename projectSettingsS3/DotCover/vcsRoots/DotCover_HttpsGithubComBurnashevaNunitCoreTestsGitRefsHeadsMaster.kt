package DotCover.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.vcs.GitVcsRoot

object DotCover_HttpsGithubComBurnashevaNunitCoreTestsGitRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/burnasheva/nunit_core_tests.git#refs/heads/master"
    url = "https://github.com/burnasheva/nunit_core_tests.git"
})
