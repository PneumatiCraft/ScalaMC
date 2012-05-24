This project serves as a proof-of-concept demonstration that Bukkit can run
plugins written in Scala, a functional language that runs on the JVM. Though the
plugin depends on numerous libraries written in Java, all source files in this
repository are entirely Scala.

## Compiling

Building this project follows the tradition of most Bukkit plugins: simply clone
and build with Maven. However, in the tradition of several other PneumatiCraft
plugins, ScalaMC depends on some external command-parsing libraries. As such,
you must also initialize Git submodules before attempting to build. Run:

    git clone https://github.com/PneumatiCraft/ScalaMC.git
    cd ScalaMC
    git submodule update --init --recursive
    mvn clean package

Notably, you **should not** need Scala installed to build this package
successfully; the Maven Scala plugin handles the compilation and linking as
necessary.

## Running

The build process (above) packages the Scala libraries with ScalaMC, resulting
in a larger plugin file but **no Scala dependency** in the final compiled JAR.
As such, you can install the plugin the same as any pure Java plugin: copy the
ScalaMC JAR file out of the `target` directory and into your Bukkit `plugins`
folder, then restart or reload your server.

ScalaMC responds to exactly one command: `hello`. When run, it will greet the
sender with a simple message. You can run this command from the console or as a
player. You may also control access to this command with the `scalamc.hello.use`
permission.

## License

ScalaMC is released under the BSD 2-clause license where applicable. However,
code from the Scala project is released under the Scala License, available
[here][scala-license].

Copyright (c) 2012 Tim Ekl
All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted provided that the following conditions are met:

* Redistributions of source code must retain the above copyright notice, this list
  of conditions and the following disclaimer.
* Redistributions in binary form must reproduce the above copyright notice, this
  list of conditions and the following disclaimer in the documentation and/or
  other materials provided with the distribution.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR
ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

[scala-license]: http://www.scala-lang.org/node/146
