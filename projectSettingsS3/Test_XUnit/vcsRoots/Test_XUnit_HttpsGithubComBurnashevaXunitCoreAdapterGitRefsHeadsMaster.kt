package Test_XUnit.vcsRoots

import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.vcs.GitVcsRoot

object Test_XUnit_HttpsGithubComBurnashevaXunitCoreAdapterGitRefsHeadsMaster : GitVcsRoot({
    name = "https://github.com/burnasheva/xunit_core_adapter.git#refs/heads/master"
    url = "https://github.com/burnasheva/xunit_core_adapter.git"
    param("teamcity:vcsResourceDiscovery:versionedSettingsRoot", "false")
})
