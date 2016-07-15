(ns knope.routes.home
  (:require [knope.layout :as layout]
            [knope.db.core :refer [find-page-by-uri-slug create-revision!]]
            [compojure.core :refer [defroutes GET POST]]
            [ring.util.http-response :refer [found]]))

(defn wiki-page [page]
  (layout/render
   "wiki-page.html" page))

(defn edit-page [page]
  (layout/render
   "edit-page.html" page))

(defroutes home-routes
  (GET "/" [] (found "/home"))
  (GET "/:uri_slug" [uri_slug]
    (if-let [page (find-page-by-uri-slug {:uri_slug uri_slug})]
      (wiki-page page)))
  (GET "/:uri_slug/edit" [uri_slug]
    (if-let [page (find-page-by-uri-slug {:uri_slug uri_slug})]
      (edit-page page)))
  (POST "/:uri_slug" {{:keys [uri_slug title body] :as params} :params}
    (when-let [page (find-page-by-uri-slug {:uri_slug uri_slug})]
      (create-revision! {:page_id (:id page)
                         :body body
                         :title title})
      (wiki-page params))))

