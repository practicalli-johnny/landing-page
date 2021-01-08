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
           :banner "https://raw.githubusercontent.com/scicloj/graphic-design/live/scicloj-community-logo-banner.png"}

          ;; TODO: replace logos with SciCloj specific (or generic) logos

          }

         :contact-channels
         {:slack {:clojurians "https://clojurians.slack.com/"
                  :scicloj    {:url  "https://clojurians.slack.com/messages/data-science"
                               :logo "https://raw.githubusercontent.com/practicalli/graphic-design/live/practicalli-slack-channel.png"}
                  :beginners  "https://clojurians.zulipchat.com/#narrow/stream/beginners"}

          :zulip {:clojurians   "https://clojurians.zulipchat.com/"
                  :scicloj      {:url  "https://clojurians.zulipchat.com/#narrow/stream/scicloj"
                                 :logo "https://raw.githubusercontent.com/practicalli/graphic-design/live/practicalli-zulip-channel.png"}
                  :events       "https://clojurians.zulipchat.com/#narrow/stream/events"
                  :data-science "https://clojurians.zulipchat.com/#narrow/stream/data-science"}

          :discord {:not-slack {:register ""
                                :url      ""
                                :logo     "https://raw.githubusercontent.com/practicalli/graphic-design/live/practicalli-discord-channel.png"}}}
         }))


;; Application
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn multiply [a b] (* a b))


(defn page-layout
  "The layout of components on the main page."
  []
  [:div
   [content/navigation (get-in @app-state [:website-assets :scicloj])]

   [content/title-banner (get-in @app-state [:website-assets :scicloj])]



   [content/level-separator "contact"]
   [content/contact (get @app-state :contact-channels)]

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
