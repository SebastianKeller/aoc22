(ns aoc22.03)

(defn split-line [input]
  (split-at (/ (count input) 2) input))

(defn find-character [arr]
  (first (apply clojure.set/intersection (map set arr))))

(defn character-priority [character]
 (let [code (int character)]
   (cond
     (>= code (int \a)) (inc  (- code (int \a)))
     :else              (+ 27 (- code (int \A))))))

(defn part-1
  ([] (part-1 (slurp "inputs/03.txt")))
  ([input] (transduce (comp
                       (map split-line)
                       (map find-character)
                       (map character-priority)) + (clojure.string/split-lines input))))

(defn part-2
  ([] (part-2 (slurp "inputs/03.txt")))
  ([input] (transduce (comp
                       (partition-all 3)
                       (map find-character)
                       (map character-priority)) + (clojure.string/split-lines input))))

(comment
  (part-1)
  (part-2))
