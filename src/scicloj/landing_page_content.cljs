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
             :data-target "navbarScicloj"}
      ;; Empty spans needed for navbar burger
      [:span] [:span] [:span]]]
    [:div {:id    "navbarScicloj"
           :class "navbar-menu"}
     [:div {:class "navbar-start"}
      [:a {:class "navbar-item"
           :href  "#videos"} "Videos"]
      [:a {:class "navbar-item"
           :href  "#getting-started"} "Getting Started"]
      [:a {:class "navbar-item"
           :href  "#handbook"} "Handbook"]
      [:a {:class "navbar-item"
           :href  "#contact"} "Contact"]]

     [:div {:class "navbar-end"}
      [:a {:class "navbar-item has-text-weight-bold"
           :href  (website-assets :blog)} "Blog"]
      [:a {:class "navbar-item has-text-weight-bold"
           :href  (website-assets :guides)} "Guides"]
      [:span {:class "navbar-item"}
       [:a {:class  "button is-inverted"
            :target "_blank"
            :href   "https://github.com/scicloj/landing-page/issues"}
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
      [:h2 {:class "subtitle"}
       "(into {:data-science \"?\"} {:data-science :clojure})"]
      [:div {:div "content"}
       [:p "A friendly and welcoming community to guide you into the fascinating journey of data science with Clojure, using the highly interactive "
        [:a {:href "https://practical.li/clojure/repl-driven-devlopment.html"}
         "REPL driven development approach"]]
       [:p "Discover the "
        [:a {:href (:guides web-assets)}
         "Clojure projects and tools"]
        " to transform data, create models and develop rich visualisations."]
       [:p "Follow SciCloj guides to learn how to apply Clojure libraries and tools to solve data science related problems"

        #_[:a {:href ""}
         "many aspects of data science"]
        ]]]
     ]]])


(defn getting-started
  "Getting Started for the SciCloj community"
  [resources]
  [:div {:class "container"}
   [:div {:class "box"}
    [:div {:class "column"}

     ;; heading
     [:h2 {:class "title has-text-centered"}
      "Getting Started"]

     ;; Tooling
     [:div {:class "column"}
      [:div {:class "box"}
       [:div {:class "columns"}
        [:div {:class "column"}
         [:a {:href   (-> resources :tools :url)
              :target "_blank"}
          [:figure {:class "image"}
           [:img {:src (-> resources :tools :logo)}]]]]
        [:div {:class "column"}
         [:h2 {:class "title has-text-centered"}
          "Tools & Notebooks"]
         [:p "REPL driven development with Clojure Editors and Notebooks"]]]]

      ;; Data Wrangling
      [:div {:class "column"}
       [:div {:class "box"}
        [:div {:class "columns"}
         [:div {:class "column"}
          [:a {:href   (-> resources :data-wrangling :url)
               :target "_blank"}
           [:figure {:class "image"}
            [:img {:src (-> resources :data-wrangling :logo)}]]]]
         [:div {:class "column"}
          [:h2 {:class "title has-text-centered"}
           "Data Wrangling"]
          [:p "Transforming and manipulating data into an appropriate shape for processing with the next function"]]]]]

      ;; Visualization
      [:div {:class "column"}
       [:div {:class "box"}
        [:div {:class "columns"}
         [:div {:class "column"}
          [:a {:href   (-> resources :data-visualization :url)
               :target "_blank"}
           [:figure {:class "image"}
            [:img {:src (-> resources :data-visualization :logo)}]]]]

         [:div {:class "column"}
          [:h2 {:class "title has-text-centered"}
           "Data Visualisation"]
          [:p "Making sense of data for a wider audience"]]]]]]]]])



(defn clojure-data-science-book
  [web-assets]
  [:div {:class "container"}
   [:div {:class "box"}

    [:div {:class "columns"}
     [:div {:class "column"}
      [:figure {:class "image"}
       [:img {:src    (-> web-assets :handbook :logo)
              :height "120px"}]]]
     [:div {:class "column"}
      [:p [:a {:href (-> web-assets :handbook :url)
               :target "_blank"
               :class "has-text-weight-bold"}
           "Clojure Data Science handbook"]
       " is where the SciCloj community is building up detailed Clojure examples for building data science related applications"]]]]])


(defn contact
  "Contact channels for the SciCloj community"
  [contact-channels]
  [:div {:class "container"}
   [:div {:class "box"}
    [:h2 {:class "title has-text-centered"}
     "Contact and Feedback"]
    [:div {:class "columns"}

     [:div {:class "column"}
      [:a {:href   (get-in contact-channels [:zulip :scicloj :url])
           :target "_blank"}
       [:figure {:class "image"}
        [:img {:src (get-in contact-channels [:zulip :scicloj :logo])}]]]]

     [:div {:class "column"}
      [:a {:href   (get-in contact-channels [:zulip :events :url])
           :target "_blank"}
       [:figure {:class "image"}
        [:img {:src (get-in contact-channels [:zulip :events :logo])}]]]]

     [:div {:class "column"}
      [:a {:href   (get-in contact-channels [:slack :scicloj :url])
           :target "_blank"}
       [:figure {:class "image"}
        [:img {:src (get-in contact-channels [:slack :scicloj :logo])}]]]

      [:a {:href   "http://clojurians.net"
           :target "_blank"}
       [:p {:class "has-text-centered"}
        "Sign up for a free account to the Clojurians Slack community"]]]
     ]]]) ;; End of contact


(defn youtube-embed-video
  "Generate an iframe to display a YouTube video,
  using a default video id as a backup value

   Argument: YouTube video id as a string
   Returns:
    Column containing an iframe for a YouTube video as hiccup"
  [video-id]
  [:div {:class "column is-3"}
   [:figure {:class "image"}
    [:iframe {:class             "embed-responsive-item"
              :allow-full-screen "allowfullscreen"
              :frame-border      0
              :auto-play         1
              :src               (str "https://www.youtube.com/embed/"
                                      (or  video-id "NDrpclY54E0"))}]]])


(defn youtube-gallery
  "Display 4 videos after shuffling the available videos"
  [videos]
  [:div {:class "container"}
   [:div {:class "box"}
    [:h2 {:class "title has-text-centered"}
     [:a {:href "https://www.youtube.com/scicloj"}
      "SciCloj Community videos"]]
    [:div {:class "columns"}
     (for [video (take 4 (shuffle videos))]
       (youtube-embed-video (:id video)))]]])


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Deprecated
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

#_(defn youtube-embed
  [video-id]
  [:div {:class "container"}
   [:div {:class "box"}
    [:h2 {:class "title has-text-centered"}
     "SciCloj Community workshops"]
    [:div {:class "column"}

     [:iframe {:class             "embed-responsive-item"
               :allow-full-screen "allowfullscreen"
               :frame-border      0
               :auto-play         1
               :src               (str "https://www.youtube.com/embed/"
                                       (if (nil? video-id)
                                         "NDrpclY54E0" video-id))}]]]])
