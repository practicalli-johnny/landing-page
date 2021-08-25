(ns ^:figwheel-hooks scicloj.landing-page
  (:require
   [goog.dom :as gdom]
   [reagent.core :as reagent :refer [atom]]
   [reagent.dom :as rdom]

   ;; SciCloj Content
   [scicloj.landing-page-content :as content]
   [scicloj.youtube-content      :as youtube]))

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
           :banner "https://raw.githubusercontent.com/scicloj/graphic-design/live/scicloj-community-logo-text-banner.png"
           :blog "https://scicloj.github.io/blog/"
           :guides "https://scicloj.github.io/guides/"
           :handbook {:url "https://scicloj.github.io/scicloj-data-science-handbook/"
                      :logo "https://raw.githubusercontent.com/scicloj/graphic-design/live/scicloj-community-handbook-banner.png"}
           :tools {:url "https://scicloj.github.io/guides/tools/"
                   :logo "https://raw.githubusercontent.com/practicalli/graphic-design/live/scicloj/data-science-clojure-notebook.png"}
           :data-wrangling {:url "https://scicloj.github.io/guides/data-wrangling/"
                            :logo "https://raw.githubusercontent.com/practicalli/graphic-design/live/scicloj/data-science-clojure-data-wrangling.png"}
           :data-visualization {:url "https://scicloj.github.io/guides/data-visualization/"
                                :logo "https://raw.githubusercontent.com/practicalli/oz-visualisations/master/resources/public/oz-visualizing-the-weather.png"}}}

         :tools {:notespace {:url  "https://github.com/scicloj/notespace"
                             :logo ""}
                 :tablecloth {:url  "https://github.com/scicloj/tablecloth"
                              :logo ""}
                 :oz {:url  "https://github.com/metasoarous/oz"
                      :logo ""}}

         :contact-channels
         {:slack {:scicloj {:url  "https://clojurians.slack.com/messages/data-science"
                            :logo "https://raw.githubusercontent.com/practicalli/graphic-design/live/scicloj/button-data-science-slack-channel.png"}}

          :zulip {:scicloj {:url  "https://clojurians.zulipchat.com/#narrow/stream/data-science"
                            :logo "https://raw.githubusercontent.com/practicalli/graphic-design/live/scicloj/button-data-science-zulip-channel.png"}
                  :events  {:url  "https://clojurians.zulipchat.com/#narrow/stream/events"
                            :logo "https://raw.githubusercontent.com/practicalli/graphic-design/live/scicloj/button-events-channel.png"}}}


         }))


;; Application
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn multiply [a b] (* a b))


(defn page-layout
  "The layout of components on the main page."
  []
  [:div
   [content/navigation (-> @app-state :website-assets :scicloj)]

   [content/title-banner (-> @app-state :website-assets :scicloj)]

   ;; Embed YouTube video
   [content/level-separator "videos"]
   [content/youtube-gallery youtube/scicloj-playlist] ;; [{:id "" :title ""} ,,,]

   [content/level-separator "getting-started"]
   [content/getting-started (-> @app-state :website-assets :scicloj)]

   [content/level-separator "handbook"]
   [content/clojure-data-science-book (-> @app-state :website-assets :scicloj)]

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
