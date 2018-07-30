(ns subway.core
  (:gen-class))

(require '[clojure.java.io :as io]
         '[clojure.string :as str]
         '[subway.mta :as subway-map])

;; ============================================================================
;; A* Search algorithm
;; ============================================================================
(defn step-cost
  ;; gets the cost between two linked nodes
  [node-name expanded]
  (first (keep #(if (= node-name (nth % 0)) (nth % 1)) expanded)))

(defn compute-path-cost
  [path node-map heuristic]

  (let [finish (keyword (first path))]
    (loop [path path cost 0]
      (if (<= (count path) 2)
        (+ cost (heuristic finish)) ; f(n) = g(n) + h(n)
        (recur
         (rest path)
         (+ cost (step-cost (first path) ((keyword (nth path 1)) node-map))))))))

(defn expand-node
     ;; Expand given node
  [path node-map]
  (let [expanded ((keyword (first path)) node-map)]
    (loop [expanded expanded discovered []]
      (if (empty? expanded)
        discovered
        (recur
         (rest expanded)
         (conj
          discovered
          (vec (flatten [(first (first expanded))
                         (vec (butlast path))
                         (compute-path-cost
                          (vec (flatten [(first (first expanded)) path]))
                          subway-map/stations
                          subway-map/distances-to-jay-st-metrotech)]))))))))

(defn initialize
  ;; generate initial state from given station name
  ;; TODO: purify by passing heuristic
  [origin]
  [origin ((keyword origin) subway-map/distances-to-jay-st-metrotech)])

(defn pathfinder
  ;; finds solution using A* search algorithm
  ;; TODO: add explored set
  [origin destination state-space]
  (if (= (keyword origin) destination)
    (seq [0 origin])
    (loop [paths [(initialize origin)]]
     ; (println (str "path:" paths))

     ;; test for destination in path
      (if (= (ffirst paths) destination)
        (rseq (first paths))
        (recur
         (vec (sort-by peek (into (expand-node (first paths) state-space) (vec (rest paths))))))))))

;; ============================================================================
;; Main
;; ============================================================================
(defn -main
  "Subway: Find an optimal path to Jay St Metrotech."
  [& args]

  (println "\nEnter a starting station: ")
  (println (pathfinder (read-line) :jay-st-metrotech subway-map/stations))
  (println "done.\n"))
