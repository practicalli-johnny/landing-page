# SciCloj landing-page

The main landing page for the SciCloj Clojure data science community, the starting page for discovering the SciCloj community activities and learning about relevant projects.


## Development

To get an interactive development environment run:

    clojure -M:figwheel:build

This will auto compile and send all changes to the browser without the
need to reload. After the compilation process is complete, you will
get a Browser Connected REPL. An easy way to try it is:

    (js/alert "Am I connected?")

and you should see an alert in the browser window.

## Test project
Run project tests using the command:

    clojure -M:figwheel:test


## Build project
To clean all compiled files:

    rm -rf target/public

To create a production build run:

    rm -rf target/public
    clojure -M:figwheel:minify


## License

Copyright © 2018 SciCloj

Distributed under the Creative Commons Attribution Share-Alike 4.0 International
