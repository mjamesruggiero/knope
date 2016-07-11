(ns knope.env
  (:require [selmer.parser :as parser]
            [clojure.tools.logging :as log]
            [knope.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init
   (fn []
     (parser/cache-off!)
     (log/info "\n-=[knope started successfully using the development profile]=-"))
   :stop
   (fn []
     (log/info "\n-=[knope has shut down successfully]=-"))
   :middleware wrap-dev})
