package Build.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.vcs.GitVcsRoot

object Build_HttpsGithubComBurnashevaXunitCoreAdapter : GitVcsRoot({
    name = "https://github.com/burnasheva/xunit_core_adapter"
    url = "https://github.com/burnasheva/xunit_core_adapter"
})
