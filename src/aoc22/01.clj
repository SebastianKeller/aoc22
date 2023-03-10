(ns aoc22.01
  (:require [clojure.string :as str]))

(defn parse-numbers [line]
  (map parse-long (str/split-lines line)))

(defn parse-input [input]
  (->> (str/split input #"\n\n")
       (map parse-numbers)
       (map #(reduce + %))))

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
