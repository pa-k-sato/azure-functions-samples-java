# overview

[このリポジトリ](https://github.com/Azure-Samples/azure-functions-samples-java)
を変更して`azure-functions`を試しました
- kotlin で書けるか
- spring アプリケーションを動かせるか

## 状況
- わかったこと
    - kotlinで書ける
    - HTTPトリガなら Spring アプリケーションが動く
- わかっていないこと
    - kotlinで書ける
    - タイマートリガでSpring アプリケーションを動かす方法
    - `build.gradle`のkotlin DSL 化

## 詳しくは
- コミットログを参照してください( d2a1373 以降)
- `koylin`ソースフォルダを参照してください

# これ
https://docs.microsoft.com/ja-jp/azure/azure-functions/functions-create-first-java-gradle

## 実行
`JAVA_HOME`の設定が必要

ローカルで動かすセットアップは必要です。Wikiを参照してください。


```bash
export JAVA_HOME=$(/usr/libexec/java_home -v 1.8)
gradle jar --info
gradle azureFunctionsRun
```

# timer trigger
npm インストールした azurite を起動
```bash
mkdir work
azurite --silent --location ./work --debug ./work/debug.log
```

## 参考
- [azure functions timer trigger](https://docs.microsoft.com/en-us/azure/azure-functions/functions-bindings-timer?tabs=java)

# 以下、元々あったもの

# Azure Functions example in Java

This sample show a basis usage for how to use *http-trigger* for [Azure Functions](https://docs.microsoft.com/en-us/azure/azure-functions/) in Java.

## Contents

Outline the file contents of the repository. It helps users navigate the codebase, build configuration and any related assets.

| File/folder       | Description                                |
|-------------------|--------------------------------------------|
| `src`             | Sample source code.                        |
| `.gitignore`      | Define what to ignore at commit time.      |
| `build.gradle`    | The gradle configuration to this sample.   |
| `pom.xml`         | The maven configuration to this sample.   |
| `CHANGELOG.md`    | List of changes to the sample.             |
| `CONTRIBUTING.md` | Guidelines for contributing to the sample. |
| `README.md`       | This README file.                          |
| `LICENSE.txt`         | The license for the sample.                |

## Prerequisites

- Gradle 4.10+
- Latest [Function Core Tools](https://aka.ms/azfunc-install)
- Azure CLI. This plugin use Azure CLI for authentication, please make sure you have Azure CLI installed and logged in.

## Setup

```cmd
az login
az account set -s <your subscription id>
```

## Running the sample

```cmd
./mvnw clean package azure-functions:run
```

```cmd
./gradlew clean azureFunctionsRun
```

## Deploy the sample on Azure


```cmd
./mvnw clean package azure-functions:deploy
```

```cmd
./gradlew clean azureFunctionsDeploy
```

> NOTE: please replace '/' with '\\' when you are running on windows.


## Contributing

This project welcomes contributions and suggestions.  Most contributions require you to agree to a
Contributor License Agreement (CLA) declaring that you have the right to, and actually do, grant us
the rights to use your contribution. For details, visit https://cla.opensource.microsoft.com.

When you submit a pull request, a CLA bot will automatically determine whether you need to provide
a CLA and decorate the PR appropriately (e.g., status check, comment). Simply follow the instructions
provided by the bot. You will only need to do this once across all repos using our CLA.

This project has adopted the [Microsoft Open Source Code of Conduct](https://opensource.microsoft.com/codeofconduct/).
For more information see the [Code of Conduct FAQ](https://opensource.microsoft.com/codeofconduct/faq/) or
contact [opencode@microsoft.com](mailto:opencode@microsoft.com) with any additional questions or comments.

## Telemetry
This project collects usage data and sends it to Microsoft to help improve our products and services.
Read Microsoft's [privacy statement](https://privacy.microsoft.com/en-us/privacystatement) to learn more.
If you would like to opt out of sending telemetry data to Microsoft, you can set `allowTelemetry` to false in the plugin configuration.
Please read our [document](https://github.com/microsoft/azure-gradle-plugins/wiki/Configuration) to find more details about *allowTelemetry*.
