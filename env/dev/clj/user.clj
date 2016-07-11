(ns user
  (:require [mount.core :as mount]
            knope.core))

(defn start []
  (mount/start-without #'knope.core/repl-server))

(defn stop []
  (mount/stop-except #'knope.core/repl-server))

(defn restart []
  (stop)
  (start))


