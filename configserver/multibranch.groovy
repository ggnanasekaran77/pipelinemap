multibranchPipelineJob('configserver') {
    branchSources {
        branchSource {
            source {
                git {
                    id('configserver')
                    remote('https://github.com/ggnanasekaran77/configserver.git')
                    traits {
                        gitBranchDiscovery()
                    }
                }
            }
            buildStrategies {
                buildAllBranches {
                    strategies {
                        skipInitialBuildOnFirstBranchIndexing()
                    }
                }
            }
        }
    }
    triggers {
        computedFolderWebHookTrigger {
            token('configserver')
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}