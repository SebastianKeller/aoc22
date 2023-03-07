(ns aoc22.01
  (:require [clojure.string :as str]))

(defn parse-input [input]
  (->> input
      (str/split-lines)               ; ("1000" "2000" "3000" "" "4000" "" ..)
      (partition-by empty?)           ; (("1000" "2000" "3000") ("") ("4000") ("") ...)
      (filter #(not-empty (first %))) ; (("1000" "2000" "3000") ("4000") ("5000" "6000") ...)
      (map (fn [group] (reduce + (map parse-long group)))))) ; (6000 4000 11000 ...)

(defn solution-1 [input]
  (->> input
       (parse-input)
       (apply max)))

(defn solution-2 [input]
  (->> input
       (parse-input)
       (sort-by -)
       (take 3)
       (reduce + 0)))

(defn part-1 [] (solution-1 (slurp "inputs/01.txt")))
(defn part-2 [] (solution-2 (slurp "inputs/01.txt")))
