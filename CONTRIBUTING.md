# Fluxnova Contribution and Governance Policies

Thank you for your interest in contributing to this project!

To ensure consistency across all repositories, we maintain a single set of **Contribution and Governance Guidelines** in the main Fluxnova repository.

Please refer to the main **[CONTRIBUTING.md](https://github.com/finos/fluxnova-bpm-platform/blob/main/CONTRIBUTING.md)** file.

## Binary files

Do not commit generated executables or other build output, such as `*.jar`, `*.class`, `*.war` or `*.zip` files ([OSPS-QA-05.01](https://baseline.openssf.org/)). Reviewers can't see what changed inside them, and everything this project ships is built from source by Maven.

The Maven wrapper is script-only (`distributionType=only-script`), so `./mvnw` downloads the pinned Maven version without a wrapper jar.

The `Check binary files` workflow fails any pull request that adds one of these files.
