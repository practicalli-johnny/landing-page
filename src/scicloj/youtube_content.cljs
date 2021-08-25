(ns scicloj.youtube-content)

;; TODO: pull video id's from YouTube directly, preferably via a cache to not impede rendering of the page

(def scicloj-playlist
  [{:id    "3zXnmV5Hzg8"
    :title "How to build a data science community"}
   {:id    "LxZ80XUmnjM"
    :title "Building a positive SciCloj community"}
   {:id    "2tGk1Jh7dJs"
    :title "12.2: Literate programming with Notespace, data visualizations with Hanami"}
   {:id    "d6qOzPQ9NUk"
    :title "FXL - composable data-oriented spreadsheet library for Clojure - Anthony Khong - Scicloj Meeting 20"}
   {:id    "44Q9ew9JH_U"
    :title "Common Lisp for the Curious Clojurian - Alan Dipert - Scicloj meeting 19"}
   {:id    "t1X-Oln1u24"
    :title "Skija graphics library for the JVM - Nikita Prokopov - Scicloj meeting 18"}
   {:id    "PmTwN_sEsJo"
    :title "Drawing Geographical Maps - Joanne Cheng - Scicloj meeting 17"}
   {:id    "hm7LoqvaYXk"
    :title "Reveal - Read Eval Visualize Loop for Clojure development - Scicloj meeting 16"}
   {:id    "dayMZjQcVaY"
    :title "Healthcare Data Science in Clojure - Scicloj meeting 15"}
   {:id    "d628Oggm-nU"
    :title "Urban planning and Geospatial analysis - Will Cohen - Scicloj meeting 14"}
   {:id    "3R2FJQdtLf8"
    :title "Geni - dataframe library on Spark - Anthony Khong - Scicloj interview 3 "}
   {:id    "qsC7aNDRRrs"
    :title "Machine Learning in Clojure - Scicloj meeting 13 - Sep 2020"}
   {:id    "SXmJ6HdLJGA"
    :title "Lightning talks and discussions on Clojure data science - Scicloj meeting 12 - Aug 2020"}
   {:id    "zYNlZXTV14E"
    :title "Building Clojure data science ecosystem - Chris Nuernberger - Scicloj Interview 2"}
   {:id    "DqVh7VEzQaI"
    :title "Saite interactive document creation - visualizing COVID-19 data tutorial - Jon Anthony"}
   {:id    "-441SPx8lTo"
    :title "SciCloj community - CovId-19 Hackathon - March 2020"}
   {:id    "GFyv3qUXHpU"
    :title "Reproducible Notebooks with Guix-Jupyter - Ludovic Courtès - Scicloj meeting 10"}
   {:id    "YhP6tI22uQ4"
    :title "Malli - plain data schemas in Clojure - Tommi Reiman - Scicloj meeting 9"}
   {:id    "Hjo4TEV81sQ "
    :title "Datahike and Datalog - Konrad Kühne - Scicloj meeting 8"}
   {:id    "XoVX2Ezi_YM"
    :title "Clojure and R interop - Daniel Slutsky - Scicloj meeting 7"}
   {:id    "3Hx7kbub9YE "
    :title "Hanami & Saite data science visualisation with Clojure - Jon Anthony - Scicloj meeting 6"}
   {:id    "CRLvHgQzhmI"
    :title "Oz - vega-lite data science visualisations in Clojure - Christopher Small - Scicloj meeting 5"}
   {:id    "ld5du3L-emM "
    :title "Interactive data visualization with Hanami & Saite - Jon Anthony - Scicloj interview 1"}
   {:id    "ajDiGS73i2o"
    :title "Libpython-clj with Chris Nuernberger and Panthera with Alan Marazzi - Scicloj meeting 4"}
   {:id    "MI9tl-3kNS0"
    :title "Nextjournal polyglot notebook service in Clojure - Martin Kavalar - Scicloj meeting 3"}
   {:id    "niCq-pvDyZc "
    :title "MXNet - Deep Learning with Clojure - Carin Meier - Scicloj meeting 2"}
   {:id    "NyMABoUEj20"
    :title "Tech.ml - new Clojure Machine Learning and ETL platform - Chris Nuernberger - Scicloj meeting 1"}])
