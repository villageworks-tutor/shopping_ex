# サンプルショッピングサイト構築・実装例

このレポジトリは、研修テキストの『サンプルショッピングサイトの構築』の実装例です。

Eclipseによる開発を前提としてEclipeのプロジェクトとして作成していますが、.projectsやsettingsなどEclipseのプロジェクトに関するファイルは管理対象ファイルからは外しています。
また、JDBCとJSTLを利用していますが、これらも管理対象ファイルから外しています。したがって、本レポジトリをForkして利用する際は以下のファイルを別途入手してください。

  - JDBC PostgreSQL用JDBC 42.9以降
  - JSTL v1.2以降

なお、利用するデータベース生成とサンプルレコード投入用のSQLについては WEB-INF/db ディレクトリに配置しています。

## 実習環境について

  - 開発環境：Eclipse（Pleiades All In One）
  - データベース：PostgreSQL
  - ユニットテスト：JUnit5（Pleiades バンドル版）

ユニットテストフレームワークは必要に応じてプロジェクトのビルドパスに追加してください。

## バージョンに対応する実装内容について

タグ名として採用しているバージョン番号と更新内容の対応については、別途 version.md を参照してください。

## 利用方法

基本的には、forkすることを想定しています。あらかじめ自身のGitHubアカウントにサインインしてください。
以下では、「公開レポジトリ」ということばを fork 元レポジトリという意味で使用しています。したがって、ここでは「本レポジトリ」として考えて差し支え有りません。

  1. 公開レポジトリのURLをコピーします。
  2. 公開レポジトリを開きます。
  3. ページ右上の［Fork］ボタンをクリックします。
  4. fork が完了すると、自身のGitHubアカウントにコピーされた公開レポジトリに遷移します。

以上の手順で、自身のセントラルレポジトリへの取り込みが完了します。
Eclipse上で、自身のセントラルレポジトリにある shopping レポジトリをインポートすることで、通欧通りの開発をすすめることができます。

ro-karunikuro-nnsurukotode 


【公開レポジトリと同期をとる方法】

fork 後の公開レポジトリの変更を取り込む（公開レポジトリと同期をとる）方法は、以下の手順となります。

  1. 公開レポジトリをリモートレポジトリとして「upstream」というエイリアス名で追加登録します。
  2. pull元を「upstrem」として pull を実行します。

　　　コマンド例：git pull upstream main

なお、公開レポジトリに変更を反映したい場合（公開レポジトリにpushしたい場合）は、公開レポジトリのアカウントにpull-requestを送って、変更依頼を行います。ただし、単に「依頼」なので「必ずしもアクセプトさルトは限らない（リジェクトされることもある）」ことを留意してください。