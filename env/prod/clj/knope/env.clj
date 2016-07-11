(ns knope.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[knope started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[knope has shut down successfully]=-"))
   :middleware identity})
