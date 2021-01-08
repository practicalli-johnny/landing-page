(ns scicloj.landing-page-content)

;; basic logging / debugging
(println (js/Date.) "Reloading: src/scicloj/landing_page_content.cljs")


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
