(ns ^:figwheel-hooks scicloj.landing-page
  (:require
   [goog.dom :as gdom]
   [reagent.core :as reagent :refer [atom]]
   [reagent.dom :as rdom]
   [scicloj.landing-page-content :as content]))

;; Basic logging / debugging

(println "This text is printed from src/scicloj/landing_page.cljs. Go ahead and edit it and see reloading in action.")

;; Application State
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

;; define your app data so that it doesn't get over-written on reload
(defonce app-state
  (atom {:page-title "SciCloj Clojure Data Science Community"
         :website-assets
         {:scicloj
          {:logo   "https://raw.githubusercontent.com/scicloj/graphic-design/live/sci-cloj-logo-name-white-background.png"
           :banner "https://raw.githubusercontent.com/scicloj/graphic-design/live/scicloj-community-logo-banner.png"}}

         :tools {:repl-driven-development
                 {:url  "https://github.com/scicloj/notespace"
                  :logo "https://raw.githubusercontent.com/practicalli/graphic-design/live/scicloj/data-science-clojure-notebook.png"}

                 :data-wrangling
                 {:url  "https://github.com/scicloj/tablecloth"
                  :logo "https://raw.githubusercontent.com/practicalli/graphic-design/live/scicloj/data-science-clojure-data-wrangling.png"}

                 :visualisation
                 {:url  "https://github.com/metasoarous/oz"
                  :logo "https://raw.githubusercontent.com/practicalli/oz-visualisations/master/resources/public/oz-visualizing-the-weather.png"}}

         :contact-channels
         {:slack {:scicloj {:url  "https://clojurians.slack.com/messages/data-science"
                            :logo "https://raw.githubusercontent.com/practicalli/graphic-design/live/scicloj/button-data-science-slack-channel.png"}}

          :zulip {:scicloj {:url  "https://clojurians.zulipchat.com/#narrow/stream/data-science"
                            :logo "https://raw.githubusercontent.com/practicalli/graphic-design/live/scicloj/button-data-science-zulip-channel.png"}
                  :events  {:url  "https://clojurians.zulipchat.com/#narrow/stream/events"
                            :logo "https://raw.githubusercontent.com/practicalli/graphic-design/live/scicloj/button-events-channel.png"}}}

         :external-content
         {:youtube [{:id    "3zXnmV5Hzg8"
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
                     :title "Tech.ml - new Clojure Machine Learning and ETL platform - Chris Nuernberger - Scicloj meeting 1"}
                    ]}}))


;; Application
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn multiply [a b] (* a b))


(defn page-layout
  "The layout of components on the main page."
  []
  [:div
   [content/navigation (get-in @app-state [:website-assets :scicloj])]

   [content/title-banner (get-in @app-state [:website-assets :scicloj])]

   ;; Embed YouTube video
   ;; TODO: improve layout? add several videos in a column?
   [content/level-separator "videos-broadcasts"]
   [content/youtube-gallery (-> @app-state :external-content :youtube)] ;; [{:id "" :title ""} ,,,]

   [content/level-separator "getting-started"]
   [content/getting-started (-> @app-state :tools)]

   [content/level-separator "books"]
   [content/clojure-data-science-book (get-in @app-state [:website-assets :scicloj])]

   [content/level-separator "contact"]
   [content/contact (get @app-state :contact-channels)]

   #_[content/level-separator "support"]
   #_[content/support-practicalli (get @app-state :support-channels)]

   #_[content/sponsorship (get-in @app-state [:support-channels :clojurists-together])]

   #_[content/level-separator "resources"]
   #_[content/resources]
   ])


;; System components
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn get-app-element []
  (gdom/getElement "app"))

(defn mount [element]
  (rdom/render [page-layout] element))

(defn mount-app-element []
  (when-let [element (get-app-element)]
    (mount element)))

;; conditionally start your application based on the presence of an "app" element
;; this is particularly helpful for testing this ns without launching the app
(mount-app-element)

;; specify reload hook with ^;after-load metadata
(defn ^:after-load on-reload []
  (mount-app-element)
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
