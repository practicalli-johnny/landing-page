(ns scicloj.landing-page-content)

;; basic logging / debugging
(println (js/Date.) "Reloading: src/scicloj/landing_page_content.cljs")


;; helper functions
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


(defn level-separator
  "A separator to provide a gap between components.
  The separator takes an id so that the section
  does not get hidden by the menu when linking"
  [identifier]
  [:div {:class "level"
         :id    identifier}
   [:h5 {:class "is-size-5 is-invisible"}
    identifier]])



;; Navigation
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn navigation
  [website-assets]
  [:nav {:class      "navbar is-fixed-top is-success"
         :role       "navigation"
         :aria-label "main navigation"}
   [:div {:class "container"}
    [:div {:class "navbar-brand"}
     [:a {:class "navbar-item"
          :href  "/"}
      [:img {:src (:banner website-assets)}]]
     [:span {:class       "navbar-burger burger"
             :data-target "navbarPracticalli"}
      ;; Empty spans needed for navbar burger
      [:span][:span][:span]]]
    [:div {:id    "navbarPracticalli"
           :class "navbar-menu"}
     [:div {:class "navbar-start"}

      [:a {:class "navbar-item"
           :href  "/blog/"} "Blog"]

      [:a {:class "navbar-item"
           :href  "#videos-broadcasts"} "Videos"]

      [:a {:class "navbar-item"
           :href  "#books"} "Books"]

      [:a {:class "navbar-item"
           :href  "#contact"} "Contact"]

      [:a {:class "navbar-item"
           :href  "#support"} "Support"]

      [:a {:class "navbar-item"
           :href  "#resources"} "Resources"]

      [:span {:class "navbar-item"}
       [:a {:class  "button is-inverted"
            :target "_blank"
            :href   "https://github.com/scicloj/landing-page-application/issues"}
        [:span {:class "icon"}
         [:i {:class "fab fa-github"}]]
        [:span "Issues/PRs"]]]]]]])



;; Content components
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;


(defn title-banner
  "Top banner and navigation for the website"
  [web-assets]
  [:section {:class "section"}
   [:div {:class "container"}
    [:div {:class "columns is-vcentered"}

     [:div {:class "column is-2 is-offset-1"}
      [:img {:src   (:logo web-assets)
             :width "120px"}]]

     [:div {:class "column"}
      [:h1 {:class "title is-1"}
       "SciCloj Community"]
      [:h3 {:class "subtitle"}
       "(conj {} :data-science :clojure)"]
      [:div {:div "content"}
       "Getting started with data science and Clojure, "
       [:a {:href "https://scicloj.github.io/pages/libraries/"}
        "using Clojure libraries and tools"]
       " to transform data, create models and develop rich visualisations.  Follow guides to install and get started with "
       [:a {:href "http://practicalli.github.io/clojure/clojure-tools/install/"}
        "Clojure"]
       "."]]
     ]]])

