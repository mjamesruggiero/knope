(ns knope.routes.home
  (:require [knope.layout :as layout]
            [knope.db.core :refer [find-page-by-uri-slug]]
            [compojure.core :refer [defroutes GET]]
            [ring.util.http-response :refer [found]]))

(defn wiki-page [page]
  (layout/render
   "wiki-page.html" page))

(defroutes home-routes
  (GET "/" [] (found "/home"))
  (GET "/:uri_slug" [uri_slug]
    (if-let [page (find-page-by-uri-slug {:uri_slug uri_slug})]
      (wiki-page page))))

